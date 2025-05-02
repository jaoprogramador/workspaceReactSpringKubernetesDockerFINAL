import axios from "axios"

import getConfig from 'next/config'
import { BookmarksResponse } from "./model";
const { serverRuntimeConfig, publicRuntimeConfig } = getConfig()
//const API_BASE_URL= 'http://localhost:8080';
const getApiUrl = () => {
    //return API_BASE_URL;
    return serverRuntimeConfig.API_BASE_URL || publicRuntimeConfig.API_BASE_URL;
}

export const fetchBookmarks = async (page: number, query: string): Promise<BookmarksResponse> => {
    console.log('SERVICE.API.TS.fetchBookmarks:::serverRuntimeConfig', serverRuntimeConfig)
    console.log('SERVICE.API.TS.fetchBookmarks:::publicRuntimeConfig', publicRuntimeConfig)
    let url = `${getApiUrl()}/api/bookmarks?page=${page}`
    if(query) {
        url += `&query=${query}`
    }
    const res = await axios.get<BookmarksResponse>(url)
    console.log("SERVICE.API:::url"+url, url)
    console.log("SERVICE.API:::res.data"+res.data, res.data)
    return res.data
}

export const saveBookmark = async (bookmark:{title: string, url: string}) => {
    console.log('SERVICE.API.TS.saveBookmark:::serverRuntimeConfig', serverRuntimeConfig)
    console.log('SERVICE.API.TS.saveBookmark:::publicRuntimeConfig', publicRuntimeConfig)
   
    const res = await axios.post(`${getApiUrl()}/api/bookmarks`, bookmark)
    return res.data
}