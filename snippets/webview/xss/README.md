## 🧩 WebView — XSS
Il Cross-Site Scripting attack si verifica quando input non attendibile viene mostrato all’interno di una WebView senza essere adeguatamente sanitizzato .

### 📡 Attacco
Simulazione di input utente in un campo di testo il cui output viene quindi interpretato e mostrato in una WebView.

### 🛠️ Snippet delle modifiche
[VulnerableWebView.java](VulnerableWebView.java)

### 🛡️ Remediation
OWASP Sanitizer e htmlEncode().

### 🗒️ Analisi completa
Link alla pagina Notion.

https://github.com/MGLabs/MGCyber/blob/main/snippets/webview/xss/VulnerableWebView.java
