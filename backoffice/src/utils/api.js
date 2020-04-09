export default function apiCall(url, method = "GET") {
    return fetch(url, {
        method
    }).then(res => res.json());
}
