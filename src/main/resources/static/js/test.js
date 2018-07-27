var page = require('webpage').create(),
    system = require('system'),
    url;

if (system.args.length === 0) {
    console.log('phantom : param error!');
    phantom.exit();
} else if (system.args.length === 1) {
    console.log('phantom : url not defined!')
} else {
    start = Date.now();
    url = system.args[1];
    page.open(url, function (status) {
        console.log(status);
        if (status === 'success') {
            console.log('phantom : canvas pics rendering done, time used:' + (Date.now() - start) + 'ms');
        } else {
            console.log('phantom : page loading failed, status =='+status + '!');
        }
        //exit phantomJs in 3 secs
        setTimeout(function () {
            phantom.exit();
        }, 3000);
    });
}