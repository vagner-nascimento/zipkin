const axios = require('axios');

module.exports = class HttpClient {

    constructor({ config }) {
        this.client = axios.create({
            baseUrl: config.http.client.baseUrl,
            timeout: config.http.client.timeout
        })
    }

    async get({ url, query }) {
        //TODO: continue from here
    }
}