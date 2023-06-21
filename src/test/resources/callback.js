const http = require('http');
const querystring = require('querystring');

const server = http.createServer((req, res) => {
    if (req.method === 'POST') {
        let data = '';

        req.on('data', chunk => {
            data += chunk;
        });

        req.on('end', () => {
            const params = querystring.parse(data);

            res.setHeader('Content-Type', 'text/plain; charset=utf-8');
            res.statusCode = 200;
            res.end(`${JSON.stringify(params)}`);
        });
    }
});

const port = 3000;
server.listen(port, () => {
    console.log(`Sunucu ${port} numaralı porta bağlandı`);
});
