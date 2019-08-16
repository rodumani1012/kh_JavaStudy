// Module call
const express = require('express')
const socket = require('socket.io')
const http = require('http')
const fs = require('fs');
var os = require('os');

// var nodeStatic = require('node-static');

// var fileServer = new (nodeStatic.Server)();

// var app = http.createServer(function (req, res) {
//     fileServer.serve(req, res);
// }).listen(8000);

// var io = socket.listen(app);

// express 객체 생성
const app = express()

// express http 서버 생성
const server = http.createServer(app)

// 생성된 서버를 socket.io에 바인딩
const io = socket(server)

app.use('/css', express.static('./static/css'))
app.use('/js', express.static('./static/js'))

// Get 방식으로 / 경로에 접속하면 실행 됨
// app.get('/', function (request, response) {
//     fs.readFile('./static/index.html', function (err, data) {
//         if (err) {
//             response.send('에러')
//         } else {
//             response.writeHead(200, { 'Content-Type': 'text/html' })
//             response.write(data)
//             response.end()
//         }
//     })
// })

io.sockets.on('connection', function (socket) {

    var room
    var user_list = []

    // 새로운 유저가 접속했을 경우 다른 소켓에게도 알려줌
    socket.on('newUser', function (name, room_num) {
        console.log(`${name} 님이 접속하였습니다.(${room_num})`)

        room = room_num
        socket.join(room)

        //소켓에 이름 저장해두기
        socket.name = name;

        var new_room = 1;

        user_list.forEach(i => {
            console.log(i._room);
            console.log(room);
            if (i._room == room) {
                console.log('new_room *= 0');
                new_room *= 0
            }
        });

        if (new_room == 1) {
            console.log('new_room');
            user_list.push({ _room: room, members: [name] })
        } else {
            console.log('new_room is not');
            user_list.forEach(i => {
                if (i._room === room) {
                    i.members.push(name)
                }
            });
        }

        // 모든 소켓에게 전송
        io.sockets.to(room).emit('update', { type: 'connect', name: 'SERVER', message: name + '님이 접속하셨습니다.' })

        user_list.forEach(i => {
            if (i._room == room) {
                console.log(i.members);
                io.sockets.to(room).emit('user_list_answer', i.members)
            }
        });
    })

    socket.on('user_list', function (room) {

        user_list.forEach(i => {
            if (i._room == room) {
                console.log(i.members);
                io.sockets.to(room).emit('user_list_answer', i.members)
            }
        });
    })

    // 전송한 메시지 받기
    socket.on('message', function (data) {
        // 받은 데이터에 누가 보냈는지 이름을 추가
        data.name = socket.name
        console.log(data)

        //보낸 사람을 제외한 나머지 유저에게 메시지 전송
        socket.broadcast.to(room).emit('update', data)
    })

    // 접속 종료
    socket.on('disconnect', function () {
        console.log(socket.name + '님이 나가셨습니다.')

        //나가는 사람을 제외한 나머지 유저에게 메시지 전송
        socket.broadcast.to(room).emit('update', { type: 'disconnect', name: 'SERVER', message: socket.name + '님이 나가셨습니다.' })
    })


    // ++++++++ draw
    socket.on('drawClick', function (data) {
        socket.broadcast.emit('draw', {
            x: data.x,
            y: data.y,
            type: data.type
        });
    });

    // +++++++++ video + audio connection

    socket.on('create or join', function (room) {
        log('Received request to create or join room ' + room);

        var clientsInRoom = io.sockets.adapter.rooms[room];
        var numClients = clientsInRoom ? Object.keys(clientsInRoom.sockets).length : 0;
        log('Room ' + room + ' now has ' + numClients + ' client(s)');

        // 방에 아무도 없으면 emit.created , socket.id 도 같이
        // socket.id : socket 별로 id가 존재 (haA4MXwl44-6kcleAAAD)
        if (numClients === 0) {
            socket.join(room);
            log('Client ID ' + socket.id + ' created room ' + room);
            socket.emit('created', room, socket.id);

            // 방에 1명이 있다면
        } else if (numClients === 1) {
            log('Client ID ' + socket.id + ' joined room ' + room);
            // room에 있는 소켓들에게 emit.join
            io.sockets.in(room).emit('join', room);
            // socket 을 room에 join
            socket.join(room);
            // socket에게 emit.joined
            socket.emit('joined', room, socket.id);
            io.sockets.in(room).emit('ready');
        } else { // max two clients
            // 2명이상이라면 
            socket.emit('full', room);
        }
    });

    socket.on('ipaddr', function () {
        var ifaces = os.networkInterfaces();
        for (var dev in ifaces) {
            ifaces[dev].forEach(function (details) {
                if (details.family === 'IPv4' && details.address !== '127.0.0.1') {
                    socket.emit('ipaddr', details.address);
                }
            });
        }
    });

    socket.on('bye', function () {
        console.log('received bye');
    });



})

// 서버를 8080포트로 listen
server.listen(8000, function () {
    console.log('서버 실행 중...')
})