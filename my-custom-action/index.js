const core = require("@actions/core");

const name = core.getInput("name", { required: true });

const greeting = `Hallo, ${name}! Willkommen zu deiner benutzerdefinierten Aktion.`;

core.setOutput("greeting", greeting);

console.log(greeting);
