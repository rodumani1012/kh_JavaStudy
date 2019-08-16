const io = require('socket.io')

io.sockets.on('connection', function (socket) {
    socket.on('join', (room) => {
        const clients = io.sockets.adapter.rooms[room]
        const numClients = (typeof clients !== 'undefined') ? clients.length : 0
        if (numClients > 1) {
            return callback('already_full')
        }
        else if (numClients === 1) {
            socket.join(room)
            io.in(room).emit('ready')
        }
        else {
            socket.join(room)
        }
        callback()
    })

    socket.on('offer', (data) => {
        const { room, candidate } = data
        socket.to(room).emit('offer', candidate)
    })

    socket.on('answer', (data) => {
        const { room, candidate } = data
        socket.to(room).emit('answer', candidate)
    })

    socket.on('candidate', (data) => {
        const { room, candidate } = data
        socket.to(room).emit('candidate', candidate)
    })
})