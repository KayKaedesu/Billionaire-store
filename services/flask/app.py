from flask import *
# from flask import url_for

app = Flask(__name__)


@app.route("/<int:a>/<int:b>", methods=['POST'])
def cal(a, b):
    if request.method == 'POST':
        return f'{a+b}'
