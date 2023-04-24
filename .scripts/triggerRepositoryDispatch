const fetch = require('node-fetch');

const owner = 'AdrianRi99';
const repo = 'TicTacToe';
const token = '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';

const dispatchEvent = async () => {
  const response = await fetch(`https://api.github.com/repos/${owner}/${repo}/dispatches`, {
    method: 'POST',
    headers: {
      'Authorization': `token ${token}`,
      'Accept': 'application/vnd.github.everest-preview+json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      event_type: 'open-repository'
    })
  });

  if (response.ok) {
    console.log('Dispatch event sent successfully');
  } else {
    console.log(`Error sending dispatch event: ${response.status} - ${response.statusText}`);
  }
};

dispatchEvent();
