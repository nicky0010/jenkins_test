properties([
    parameters([
		string(name: 'brEdfBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		string(name: 'brEdfultilsBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
	])
])

pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				script {
					echo "${workspace}"
					echo "${pwd()}"
					commonProperties = readYaml file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${pwd()}@script/${props.mavenSettingXmlPath}"
				}
			}
		}
	}
}
