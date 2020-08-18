pipeline {

    agent any

    parameters {
        string(
            name: 'JenkinsJOB',
            defaultValue: "JenkinsJOB",
            description: 'Name of source project for copying of artifact(s).'
        )
    }

    stages {

        stage('delete workspace') {
            steps {
                deleteDir()
            }
        }

        stage('copy artifacts') {
            steps {
                copyArtifacts(projectName: "${params.JenkinsJOB}")
            }
        }

        stage('find files') {
            steps {
                script {
                    files = findFiles(glob: '*.*')
                    for (file in files) {
                        echo file.name
                    }
                }
            }
        }
    }
}
