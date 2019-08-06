const { Router } = require('express');
const httpStatus = require('http-status');

const deliveriesController = {
    
    get router() {
        const router = Router();
        router.post('/deliveries/', this.create);

        return router;
    },

    create(req, res, next) {

        try {
            log.info('req.body', req.body);
            
            res
                .status(httpStatus.CREATED)
                .json({ deliveryId: 666 });
        } catch (error) {
            console.log('error', error);
            next;
        }
    }
};

module.exports = deliveriesController;