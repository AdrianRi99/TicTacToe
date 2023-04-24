const fs = require('fs');

const input = process.argv[2];

const logFile = 'logs/mylog.txt';

fs.appendFileSync(logFile, input + '\n');
