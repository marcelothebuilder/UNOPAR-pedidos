angular
  .module('app')
  .config(httpBackendConfig);

/** @ngInject */
function httpBackendConfig($httpProvider) {
  $httpProvider.interceptors.push(apiInterceptor);
  $httpProvider.interceptors.push(responseDataExtractorInterceptor);
}

const API_URL = 'http://localhost:8080';

function responseDataExtractorInterceptor($q) {
  return {
    response: response => {
      const url = response.config.url;

      // ignore template requests
      if (url.substr(url.length - 5) === '.html') {
        return response || $q.when(response);
      }

      return response.data || $q.when(response.data);
    }
  };
}

/** @ngInject */
function apiInterceptor($q) {
  return {
    request: config => {
      const url = config.url;

      // ignore template requests
      if (url.substr(url.length - 5) === '.html') {
        return config || $q.when(config);
      }

      if (url.substr(0, 4) === 'http') {
        return config || $q.when(config);
      }

      config.url = API_URL + config.url;
      return config || $q.when(config);
    }
  };
}
