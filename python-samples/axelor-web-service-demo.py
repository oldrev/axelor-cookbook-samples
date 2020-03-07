#encoding: utf-8
# 演示访问 Axelor Web Service 的 Python 脚本
# 作者：命师

import requests

URL = 'http://127.0.0.1:3000/axelor-demo-03'
USERNAME = 'admin'
PASSWORD = 'admin'

session = requests.Session()

# 提交用户名和密码执行登录
login_form = {'username': USERNAME, 'password': PASSWORD}
url = URL + '/callback'
response = session.post(url, data=login_form)

# 调用 Web Service 查询并显示系统中所有的用户
url = URL + '/ws/rest/com.axelor.auth.db.User'
response = session.get(url)
obj = response.json()
print('Users in Axelor:\n')
for record in obj['data']:
    print('ID={0}\tName={1}\t\t\t\t'.format(record['id'], record['name']))
