module.exports = function(app){
    app.get('/', function(req,res){
        res.send('Hello World~')
    });

    app.get('/bye', function(req, res){
        res.send('Bye NODE');
    });

    // require('body-parser');
    app.post('/test', function(req, res){
        var name = req.body.name;
    });
}