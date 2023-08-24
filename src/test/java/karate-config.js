function config() {
    var environment = karate.env
    if(!environment){
        environment = 'dev'; //set the environment if not present, this will be usefull when test in multiple environments
    }
    karate.log('Karate Running Environment:', environment);
    karate.configure("ssl",true); //Enabling HTTPS calls
    var now = new Date();
    var config = {
        baseUrl: 'https://gitlab.com/', //Base Url for GitLab
        tokenUrl: 'https://gitlab.com/oauth/token',   // Url to generate oauth token
        authCodeUrl: 'https://gitlab.com/oauth/authorise',  // Url to generate authorization code for token generation
        clientId: '#Enter Client Id',  // Client Id for token generation
        clientSecret: '#Enter Client Secret', // client secret for token generation
        redirectUri: '#Enter Redirect URI here', // redirect uri for token generation
        code: '#Auth Code', // auth code for token generation
        grantType: 'authorization_code', // grant type for token generation
        projectId: 47981345, // project id used to work 
        privateToken: '#Private Token', // Authorization token
        accessToken: karate.properties['karate.oauth2'] || '', // Oauth2 token(This is from command line input)
        timeStamp: now.toString() // fetch the current time 
    }

    //Below condition will check if the oauth token present in the arguments or not
    //If oauth present it will use the oauth else it will use private-token
    if(config.accessToken!=''){
        karate.configure('headers',{'Authorization': 'Bearer ' + config.accessToken, 'Accept':'application/vnd.github+json'});
    }else{
        karate.configure('headers',{'Private-Token':config.privateToken,'Accept':'application/vnd.github+json'});
    }
    
    return config;
}