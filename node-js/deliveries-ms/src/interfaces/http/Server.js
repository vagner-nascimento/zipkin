const express = require('express');
const helmet = require('helmet');
// const spdy = require('spdy');

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

            const server = this.express.listen(this.config.http.port, () => {

                const { port } = server.address();
                const message = `pID: ${process.pid} - Listening at port: ${ port }`;

                console.log('Server UP - ', message);
                resolve();
            });

            /* 
                Tried with SSL, but doesn't works and i believe that is 
                because my cert doesn't have an authentication authority
            */
            // const server = spdy.createServer(this.config.http.ssl, this.express)
            //                     .listen(this.config.http.port, () => {
            //                         console.log('server', server);
            //                         const { port } = server.address();
            //                         const message = `pID: ${process.pid} - Listening at port: ${ port }`;                                                                        
            //                         console.log('Server UP - ', message);
            //                         resolve();
            //                     });
        });
    }
}

module.exports = Server;