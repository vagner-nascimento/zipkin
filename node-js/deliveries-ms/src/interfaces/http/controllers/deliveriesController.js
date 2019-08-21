const { Router } = require('express');
const httpStatus = require('http-status');

const deliveriesController = {
    
    get router() {
        const router = Router();
        router.post('/deliveries/', this.create);

        return router;
    },

    create: (req, res, next) => { //Figure out how to inject operation here

        try {
            console.log('req.body', req.body);
            const delivery = { its_everything: 'OK' };
            res
                .status(httpStatus.CREATED)
                .json(delivery);
        } catch (error) {
            console.log('error', error);
            next;
        }
    }
};

module.exports = deliveriesController;