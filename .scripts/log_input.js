function showInputPrompt() {
  const inputPrompt = document.getElementById('input-prompt');
  inputPrompt.style.display = 'block';
}

function logInput() {
  const inputText = document.getElementById('input-text').value;
  const logFile = 'input-log.md';
  const commitMessage = 'Added input to log file';

  const date = new Date();
  const dateString = date.toLocaleString();
  const logText = `## ${dateString}\n\n${inputText}\n\n`;

  const path = 'logs/';
  const fileName = `${date.toISOString().slice(0, 10)}-${logFile}`;
  const filePath = `${path}${fileName}`;

  const octokit = new Octokit();
  octokit.rest.repos.createOrUpdateFileContents({
    owner: 'AdrianRi99',
    repo: 'TicTacToe.git',
    path: filePath,
    message: commitMessage,
    content: btoa(logText),
    committer: {
      name: 'AdrianRi99',
      email: 'adrian11820@gmail.com',
    },
    author: {
      name: 'AdrianRi99',
      email: 'adrian11820@gmail.com',
    },
  }).then(() => {
    const successMessage = document.getElementById('success-message');
    successMessage.style.display = 'block';
  }).catch((error) => {
    console.error(error);
  });
}

