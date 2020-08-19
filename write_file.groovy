pipeline {
    agent any
    stages {
        stage('write file') {
            steps {
                deleteDir()
                writeFile(file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/output.txt", text: "${OUTPUT_TEXT}")
            }
        }
        stage('archive artifacts') {
            steps {
                archiveArtifacts "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
            }
        }
    }
}
