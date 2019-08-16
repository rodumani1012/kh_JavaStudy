var http = require('http'); // http 모듈 요청
var fs = require('fs');
var url = require('url');

http.createServer(function(request, response){
    var _url = request.url;
    var pathName = url.parse(_url, true).pathname;

    if(pathName === '/main'){
        response.end(fs.readFileSync(__dirname + pathName + '.html'));
    } else {
        response.end('Hello World');
    }
    console.log('server listening on 3000 prompt');
}).listen(3000); // server.listen(port, [name], [callback])

