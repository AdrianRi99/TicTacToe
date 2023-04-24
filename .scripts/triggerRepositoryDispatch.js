const form = document.querySelector('form');
const input = document.querySelector('input');

form.addEventListener('submit', (event) => {
  event.preventDefault();
  
  const payload = JSON.stringify({ "event_type": "open-repository" });

  fetch(`https://api.github.com/repos/${AdrianRi99}/${TicTacToe}/dispatches`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${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}`
    },
    body: payload
  })
  .then(() => {
    const text = input.value;
    const author = github.context.payload.sender.login;
    const date = new Date().toISOString();
    const commitMessage = `Added "${text}" by ${author} on ${date}`;

    const fileContent = `Text: ${text}\nAuthor: ${author}\nDate: ${date}`;

    const octokit = new Octokit({ auth: personalAccessToken });

    octokit.repos.createOrUpdateFileContents({
      owner: AdrianRi99,
      repo: TicTacToe,
      path: 'log.txt',
      message: commitMessage,
      content: Buffer.from(fileContent).toString('base64'),
      committer: {
        name: github.context.payload.sender.login,
        email: github.context.payload.sender.email || `${github.context.payload.sender.login}@users.noreply.github.com`
      },
      author: {
        name: github.context.payload.sender.login,
        email: github.context.payload.sender.email || `${github.context.payload.sender.login}@users.noreply.github.com`
      }
    })
    .then(() => {
      console.log('Log file updated.');
    })
    .catch((error) => {
      console.error(error);
    });
  })
  .catch((error) => {
    console.error(error);
  });
});
