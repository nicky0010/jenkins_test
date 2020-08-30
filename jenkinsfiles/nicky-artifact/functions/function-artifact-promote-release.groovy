def execute(appRepository, branchName) {
    pipeline {
        stage('Promote') {
            // deleteDir()
            script {
                dir("${appRepository}") {
                    // git([url: "https://github.com/nicky0010/${appRepository}.git", branch: "${branchName}"])
                    downloadBasePath = "${pwd()}"
                    File file = new File("${downloadBasePath}/aaaa.txt")
                    promoteArtifact(downloadBasePath:"${downloadBasePath}")
                }
            }
        }
    }
    echo "Promote ${appRepository} finished."
}

def promoteArtifact(downloadBasePath){
            def md5Before = downloadArtifact(downloadBasePath)
}

def String downloadArtifact(downloadBasePath) {
    File file = new File("${downloadBasePath}/aaaa.txt")
}

return this