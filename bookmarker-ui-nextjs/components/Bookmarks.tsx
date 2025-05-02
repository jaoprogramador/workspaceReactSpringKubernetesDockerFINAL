
import React from "react";
//import {BookmarksResponse} from "../services/models";
//import Bookmark from "./Bookmark";

import Bookmark from "./Bookmark";
import Pagination from "./Pagination";
import { BookmarksResponse } from "../service/model";
//import Pagination from "./Pagination";

interface BookmarksProps {
    bookmarks: BookmarksResponse
    query?: string
}

const Bookmarks: React.FC<BookmarksProps> = ({bookmarks, query})=> (
    
    <div className="container mt-5">
        <Pagination bookmarks={bookmarks} query={query}></Pagination>
         {bookmarks.data.map(bookmark => (
            <Bookmark key={bookmark.id} bookmark={bookmark} />
        ))} 
         {/*<BookmarkCard />*/}
    </div>
);

export default Bookmarks;