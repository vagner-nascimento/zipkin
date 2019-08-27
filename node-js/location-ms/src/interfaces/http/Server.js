const express = require('express');
const helmet = require('helmet');

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
        });
    }
}

module.exports = Server;