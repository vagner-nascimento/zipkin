const { Router } = require('express');
const bodyParser = require('body-parser');
const compression = require('compression');
const methodOverride = require('method-override');
const cors = require('cors');

module.exports = ({ controllers }) => {
    const router = Router();

    router
        .use(methodOverride('X-HTTP-Method-Override'))
        .use(cors())
        .use(bodyParser.json())
        .use(compression());
        
    controllers.forEach(controller => {
        router.use(controller.router);
    });

    return router;
};