var express = require('express');
var app = express();
var router = require('./router/app')(app);

app.use(express.static('public'));

app.get('/', function (req, res) {
  res.send('Hello World!');
  /*
res.download()	파일이 다운로드되도록 프롬프트합니다.
res.end()	응답 프로세스를 종료합니다.
res.json()	JSON 응답을 전송합니다.
res.jsonp()	JSONP 지원을 통해 JSON 응답을 전송합니다.
res.redirect()	요청의 경로를 재지정합니다.
res.render()	보기 템플리트를 렌더링합니다.
res.send()	다양한 유형의 응답을 전송합니다.
res.sendFile	파일을 옥텟 스트림의 형태로 전송합니다.
res.sendStatus()	응답 상태 코드를 설정한 후 해당 코드를 문자열로 표현한 내용을 응답 본문으로서 전송합니다.*/
});

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});

/*
var http = require('http'); // http 모듈 요청
            // function(request, response) {} 의 최신버전 코드
http.createServer((request,response) => {
    return request.on('error', (err) => {
        console.log(err);
    }).on('data', (data) => {
        console.log(data);
    }).on('end', () => {
        response.on('err', (err)=>{
            console.log(err);
        });
        response.end('Hello, World!');
    });
}).listen(3000);
*/


//http.createServer(function(request, response){
//   response.end('Hello World');
//}).listen(3000); // server.listen(port, [name], [callback])

