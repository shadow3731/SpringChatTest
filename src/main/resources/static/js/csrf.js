/*let token = $("meta[name='_csrf']").attr("content");
let header = $("meta[name='_csrf_header']").attr("content");

$(document).ajaxSend((e, xhr, options) => {
    xhr.setRequestHeader(header, token);
})

const csrfToken = document.cookie.replace(/(?:(?:^|.*;\s*)XSRF-TOKEN\s*\=\s*([^;]*).*$)|^.*$/, '$1');

fetch(url, {
    method: 'POST',
    body: {
        "name": ""
    },
    headers: { 'X-XSRF-TOKEN': csrfToken }
})*/