
import React from "react";
import type {Bookmark} from '../service/model';
import Link from "next/link";

interface BookmarkProps {
    bookmark: Bookmark
}
 const Bookmark: React.FC<BookmarkProps> = ({bookmark}) => (
    <div>
        <div className="alert alert-primary" role="alert">
            <h5>
                <Link target={"_blank"} className={'text-decoration-none'} href={bookmark.url}>               
                        {bookmark.title}
                </Link>
                
            </h5>
        </div>
        
    </div>
) 
    

export default Bookmark;
