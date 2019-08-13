const { Router } = require('express');
const httpStatus = require('http-status');

const deliveriesController = {
    
    get router() {
        const router = Router();
        router.post('/deliveries/', this.create);

        return router;
    },

    create: (req, res, next) => { //Figure out how to inject operation here and how to call requires always starting with 'src/'

        try {
            console.log('req.body', req.body);
           
            res
                .status(httpStatus.CREATED)
                .json(delivery.toJSON());
        } catch (error) {
            console.log('error', error);
            next;
        }
    }
};

module.exports = deliveriesController;