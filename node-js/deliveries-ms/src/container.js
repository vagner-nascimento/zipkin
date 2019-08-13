const { createContainer, asClass, asFunction, asValue } = require('awilix');

const controllers = require('./interfaces/http/controllers');
const router = require('./interfaces/http/router');
const Server = require('./interfaces/http/Server');

const Application = require('./app/Application');
const CreateDeliveryOperation = require('./app/operation/CreateDeliveryOperation');

const LocationService = require('./domain/service/LocationService');

const config = require('../config');

const container = createContainer();

// Values
container
    .register({ controllers: asValue(controllers) })
    .register({ config: asValue(config) });

// Functions
container
    .register({ router: asFunction(router).singleton() });

// Classes
container    
    .register({ Application: asClass(Application).singleton() })
    .register({ Server: asClass(Server).singleton() })
    .register({ LocationService: asClass(LocationService).singleton() })
    .register({ CreateDeliveryOperation: asClass(CreateDeliveryOperation) });

module.exports = container;