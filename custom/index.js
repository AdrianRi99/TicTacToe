const core = require('@actions/core');
const readline = require('readline');

async function run() {
  try {
    const prompt = core.getInput('prompt');
    const rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout
    });
    const result = await new Promise((resolve) => {
      rl.question(prompt, (answer) => {
        resolve(answer);
        rl.close();
      });
    });
    core.setOutput('result', result);
  } catch (error) {
    core.setFailed(error.message);
  }
}

run();
