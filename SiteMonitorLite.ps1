$url = "http://localhost:8080/daniel-yuval-bar-chany-shani/index.jsp"
try {
    $response = Invoke-WebRequest -Uri $url -Method Get -TimeoutSec 5
    if ($response.StatusCode -eq 200) {
        Write-Output "SUCCESS: Application is UP and running at $url"
        exit 0
    } else {
        Write-Output "WARNING: Application returned an error status code."
        exit 1
    }
} catch {
    Write-Output "ERROR: Application is DOWN or unreachable."
    exit 1
}
