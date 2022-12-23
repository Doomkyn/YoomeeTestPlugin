var exec = require('cordova/exec');

exports.showNativeToast = function (arg0, success, error) {
    exec(success, error, 'YoomeeTestPlugin', 'showNativeToast', [arg0]);
};
