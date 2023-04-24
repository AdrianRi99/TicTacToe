const owner = "AdrianRi99";
const repo = "TicTacToe";
const logFilePath = "./messages/logs.txt";
const githubToken = "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";

const submitButton = document.getElementById("submit-button");
const inputField = document.getElementById("input-field");

submitButton.addEventListener("click", () => {
  const inputText = inputField.value;

  fetch(`https://api.github.com/repos/${owner}/${repo}/dispatches`, {
    method: "POST",
    headers: {
      Authorization: `Bearer ${githubToken}`,
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      event_type: "open-repository",
      client_payload: { text: inputText, path: logFilePath },
    }),
  })
    .then((response) => {
      if (response.ok) {
        console.log("Dispatch event triggered successfully");
        // clear input field
        inputField.value = "";
      } else {
        console.error("Failed to trigger dispatch event");
      }
    })
    .catch((error) => {
      console.error("Error occurred while triggering dispatch event", error);
    });
});
