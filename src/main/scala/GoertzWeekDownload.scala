package org.shoesizeme.analysis

import java.nio.file.{Files, LinkOption, Paths}

import org.apache.spark.sql.SparkSession
import org.shoesizeme.commons.util.ArgumentParser
import net.schmizz.sshj.SSHClient
import net.schmizz.sshj.sftp.{RemoteResourceFilter, RemoteResourceInfo, SFTPClient}
import net.schmizz.sshj.transport.verification.PromiscuousVerifier
import org.apache.spark.sql.functions._

import scala.collection.JavaConversions._


object GoertzWeekDownload {

}
