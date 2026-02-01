public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vulnerable_web_view, container, false);
        TextInputEditText payload = view.findViewById(R.id.payload);
        WebView webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSupportZoom(true);
        view.findViewById(R.id.execute).setOnClickListener(v -> {
            if (!Objects.requireNonNull(payload.getText()).toString().isEmpty()) {
                if (URLUtil.isValidUrl(Objects.requireNonNull(payload.getText()).toString())) {
                    webView.loadUrl(payload.getText().toString());
                } else {
                    webView.setWebChromeClient(new WebChromeClient());
                    webView.loadData(payload.getText().toString(), "text/html", "UTF-8");

                /**  // OWASP Sanitizer
                    PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);
                    String safe = policy.sanitize(payload.getText().toString());
                   webView.loadData(safe, "text/html", "UTF-8");

 
                  //HTML Escape
                    String escaped = TextUtils.htmlEncode(payload.getText().toString());
                    webView.loadData(escaped, "text/html", "UTF-8");*/
                }
            } else {
                SnackUtil.INSTANCE.simpleMessage(requireActivity(), "No payload provided!");
            }
        });
        return view;
    }

}
