	import paramiko
	import sys
	import getpass
	
	class ConfigVM(object):
	
		def __init__(self, device, username, password):
			self.ssh_conn = paramiko.SSHClient()
			self.device = device
			self.username = username
			self.password = password
	
	
		def set_dev_creds(self, device, username, password):
			self.device = device
			self.username = username
			self.password = password
	
		def connect(self):
			self.ssh_conn.set_missing_host_key_policy(paramiko.AutoAddPolicy())
			self.ssh_conn.connect(self.device, username = self.username, password = self.password)
	
		def send_cmd(self, command):
			if command:
				stdin, stdout, stderr = self.ssh_conn.exec_command(command)
	
				stdin.write('jahed123\n')
				stdin.flush()
				stdin.close()
	
				for line in stdout.read().splitlines():
					#print 'host: %s: %s' % (host[0], line)
					print (line)
				for line in stderr.read().splitlines():
					print(line)
			else:
			    print "Error"
	
		def disconnect(self):
			pass
	
	#ssh.connect('127.0.0.1', username='jesse', password='lol')
	
	def test():
		password = 'jahed123'
		client_conn = ConfigVM('192.168.22.10', 'jahed',password)
		print(client_conn.device, client_conn.username, client_conn.password)
		client_conn.connect()
	
		# Add default route
		client_conn.send_cmd("sudo -S route add default gw 192.168.22.1")	
		# Make default route persistent
		client_conn.send_cmd('sudo -S bash -c "echo \'gateway 192.168.22.2\' >> /etc/network/interfaces"')
	
		# Set NTP server setting
		client_conn.send_cmd('sudo -S bash -c  "echo \'server 8.8.8.8\' >> /etc/ntp.conf"')
	
		# Configure routing entries
		client_conn.send_cmd("sudo -S route add -net 212.204.206.0 netmask 255.255.255.0 gw 192.168.33.1 dev ens34")
		# Make routing entries persistent
		client_conn.send_cmd('sudo -S bash -c "echo \'up route add -net 212.204.206.0/24 gw 192.168.33.1 dev ens34\' >> /etc/network/interfaces"')
	
	
	
	if __name__ == '__main__':
	
		test()
