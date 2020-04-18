voted = {}

def check_voter(name):
    if voted.get(name):
        print("Send them off")
    else:
        voted[name] = True
        print("Let them vote")


import time

cache = {}

def get_data_from_server(url):
    if url == 'facebook.com':
        return 'You have one new like'
    if url == 'instagram.com':
        return 'John started following you'
    if url == 'pornhub.com':
        return 'Choose category: anal, blowjob, ...'

def get_page(url):
    if cache.get(url):
        return cache[url]
    else:
        data = get_data_from_server(url)
        cache[url] = data
        print("Server is loading data..")
        time.sleep(3)
        return data
