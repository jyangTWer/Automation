function fn() {    
  var env = karate.env; // get system property 'karate.env'
  karate.log('karate.env system property was:', env);
  if (!env) {
    env = 'dev';
  }
  var config = {
    dev: "localhost",
    test: "https://jsonplaceholder.typicode.com",
	release: 'releaseUrl',
	prod: 'prodUrl'
  };

  demoBaseUrl = config[env];

  return config;
}