def execute(appRepository, branchName, nexusSnapshotUrl, nexusReleaseUrls, nexusReleaseCredentialId, githubCredentialId, mavenSetting) {
    pipeline {
        stage('Promote') {
            deleteDir()
            script {
                dir("${appRepository}") {
                    git([url: "https://github.com/nicky0010/${appRepository}.git", branch: "${branchName}", credentialId: "${githubCredentialId}"])
                    downloadBasePath = "${pwd()}"
                    promoteArtifact(promoteData, groupId:"${appGroupId}, appVersion:"${appVersion}", downloadBasePath:"${downloadBasePath}")
                }
            }
        }
    }
    echo "Promote ${appRepository} finished."
}

def promoteArtifact(promoteData, downloadBasePath){
    promoteData.each { p ->
        stage("relese: ${p.artifactId}") {
            def md5Before = downloadArtifact(downloadBasePath)
        }

    }
}

def String downloadArtifact(downloadBasePath) {
    File file = new File("${downloadBasePath}/aaaa.txt")
}