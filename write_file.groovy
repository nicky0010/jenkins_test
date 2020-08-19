pipeline {
    agent any
    stages {
        stage('write file') {
            steps {
                deleteDir()
                writeFile(file: "${pwd()}@tmp/jenkinsfiles/nicky-artifact/envs/output.txt", text: "${OUTPUT_TEXT}")
                echo "${pwd()}"
            }
        }
    }
}
