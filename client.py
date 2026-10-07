import urllib.request

req = urllib.request.Request(
    "http://localhost:8080/servlet-request-routing/controller?page=1",
    headers={"Accept": "text/plain"},
)

print(urllib.request.urlopen(req).read().decode())
