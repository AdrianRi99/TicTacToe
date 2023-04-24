const core = require('@actions/core')
const fs = require('fs')

try {
  const inputText = core.getInput('input-text')
  fs.appendFileSync('log.txt', inputText + '\n')
  console.log(`The following text has been added to the log file: ${inputText}`)
} catch (error) {
  core.setFailed(error.message)
}
