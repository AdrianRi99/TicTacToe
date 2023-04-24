const GITHUB_PERSONAL_ACCESS_TOKEN = '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';
const REPO_OWNER = 'AdrianRi99';
const REPO_NAME = 'TicTacToe';

const payload = {
  event_type: 'my-custom-event',
  client_payload: {
    message: 'Hello World!'
  }
};

fetch(`https://api.github.com/repos/${REPO_OWNER}/${REPO_NAME}/dispatches`, {
  method: 'POST',
  headers: {
    'Authorization': `Bearer ${GITHUB_PERSONAL_ACCESS_TOKEN}`,
    'Content-Type': 'application/json'
  },
  body: JSON.stringify(payload)
})
.then(response => {
  if (!response.ok) {
    throw new Error(`HTTP error! status: ${response.status}`);
  }
  console.log('Repository Dispatch Event wurde erfolgreich ausgelöst.');
})
.catch(e => {
  console.log('Fehler beim Auslösen des Repository Dispatch Events:', e);
});
