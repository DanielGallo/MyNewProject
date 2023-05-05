import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildMetrics
import jetbrains.buildServer.configs.kotlin.projectFeatures.buildTraces
import jetbrains.buildServer.configs.kotlin.projectFeatures.eventLog
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

version = "2022.10"

project {

    buildType(Build)

    features {
    }
}

object Build : BuildType({
    name = "Build"

    params {
        param("system.VersionNumber", "")
        param("system.DeploymentUrl", "")
    }

    steps {
        script {
            scriptContent = """
                echo %system.VersionNumber%
                echo %system.DeploymentUrl%
            """.trimIndent()
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
