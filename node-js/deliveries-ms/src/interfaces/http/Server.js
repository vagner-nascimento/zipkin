const express = require('express');
const helmet = require('helmet');
const spdy = require('spdy');

class Server {

    constructor({ config, router }) {
        
        this.config = config;
        this.router = router;
        this.express = express();

        this.express.use(helmet());
        this.express.use(helmet.noCache());
        this.express.use(router);
    }

    start() {

        return new Promise(resolve => {
            const server = spdy.createServer({}, this.express)
                                .listen(this.config.httpPort, () => {
                                    const { port } = server.address();
                                    const message = `pID: ${process.pid} - Listening at port: ${ port }`;                                    
                                    
                                    console.log('Server UP - ', message);

                                    resolve();
                                });
        });
    }
}

module.exports = Server;