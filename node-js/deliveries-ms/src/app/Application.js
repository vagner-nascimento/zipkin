class Application {

    constructor({ Server }) {

        this.server = Server;
    }

    async start() {

        await this.server.start();
    }
}

module.exports = Application;