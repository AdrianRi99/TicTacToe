const core = require('@actions/core');

try {
  const message = core.getInput('message');
  console.log(`The message is: ${message}`);
} catch (error) {
  core.setFailed(error.message);
}
