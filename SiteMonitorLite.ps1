$url = "http://localhost:8080/daniel-yuval-bar-chany-shani/index.jsp"
Write-Output "Attempting to reach: $url"
try {
    $response = Invoke-WebRequest -Uri $url -Method Get -TimeoutSec 10 -UseBasicParsing
    if ($response.StatusCode -eq 200) {
        Write-Output "SUCCESS: Application is UP and running at $url"
        exit 0
    } else {
        Write-Output "WARNING: Application returned an error status code."
        exit 1
    }
} catch {
    Write-Output "ERROR: Application is DOWN or unreachable."
    Write-Output $_.Exception.Message
    exit 1
}
