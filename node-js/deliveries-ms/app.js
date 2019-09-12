const container = require('src/container');
const Application = container.resolve('Application');

Application
    .start()
    .catch(error => {
        console.log('error', error);
        process.exit();
    });